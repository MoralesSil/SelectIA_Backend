package pe.edu.upc.selecia_backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pe.edu.upc.selecia_backend.dtos.UsuarioDTO;
import pe.edu.upc.selecia_backend.entities.PerfilPostulante;
import pe.edu.upc.selecia_backend.entities.Rol;
import pe.edu.upc.selecia_backend.entities.Usuario;
import pe.edu.upc.selecia_backend.security.JwtRequest;
import pe.edu.upc.selecia_backend.security.JwtResponse;
import pe.edu.upc.selecia_backend.security.JwtTokenUtil;
import pe.edu.upc.selecia_backend.serviceImplements.EmbeddingPythonService;
import pe.edu.upc.selecia_backend.serviceImplements.JwtUserDetailsService;
import pe.edu.upc.selecia_backend.serviceInterfaces.PerfilPostulanteService;
import pe.edu.upc.selecia_backend.serviceInterfaces.RolService;
import pe.edu.upc.selecia_backend.serviceInterfaces.UsuarioService;

import java.util.List;
import java.util.Map;


//Clase 3
@RestController
@CrossOrigin
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RolService rolService; // Asegúrate de tenerlo

	@PostMapping("/registrar")
	public ResponseEntity<Void> insertar(@RequestBody UsuarioDTO usuario) {
		ModelMapper m = new ModelMapper();
		Usuario urs = m.map(usuario, Usuario.class);
		String encodedPassword = passwordEncoder.encode(urs.getContraseña());
		urs.setContraseña(encodedPassword);
		usuarioService.insert(urs);
		Rol rol = new Rol();
		rol.setRol("Postulante");
		rol.setUsuario(urs);
		rolService.insert(rol);
		return ResponseEntity.ok().build();
	}
	@Autowired
	private PerfilPostulanteService perfilPostulanteService;
	@Autowired
	private EmbeddingPythonService embeddingPythonService;



	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest req) throws Exception {
		authenticate(req.getUsername(), req.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	@GetMapping("/user/id/{username}")
	public int getUserIdByUsername(@PathVariable String username) {
		return usuarioService.findByUsername(username);
	}

	@GetMapping("/{id}")
	public UsuarioDTO listarId(@PathVariable("id") Long id  ) {
		ModelMapper m=new ModelMapper();
		UsuarioDTO dto=m.map(usuarioService.listId(id), UsuarioDTO.class);
		return dto;
	}


	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
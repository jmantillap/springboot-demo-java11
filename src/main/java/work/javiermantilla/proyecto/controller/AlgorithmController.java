package work.javiermantilla.proyecto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import work.javiermantilla.proyecto.dto.DataListDTO;
import work.javiermantilla.proyecto.dto.ErrorResponseDTO;
import work.javiermantilla.proyecto.services.IRequiredRemainderServices;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("api/v1")
public class AlgorithmController {

	@Autowired
	private IRequiredRemainderServices remainderServices;
	
	@Operation(summary = "required-remainder", description = "Servicio POST")
	@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = DataListDTO.class)))
	@ApiResponse(responseCode = "500", description = "ERROR INTERNO", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponseDTO.class)))
	@PostMapping(value = "required-remainder", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> requiredRemainderPost(@RequestBody DataListDTO data) {
		try {
			return new ResponseEntity<>(remainderServices.process(data), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, e), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}	
	
	@Operation(summary = "required-remainder", description = "Servicio GET")
	@ApiResponse(responseCode = "200", description = "OK",
	content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
	schema = @Schema(implementation = ArrayList.class)))
	@ApiResponse(responseCode = "500", description = "ERROR INTERNO",content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE
	,schema = @Schema(implementation = ErrorResponseDTO.class)))
	@GetMapping(value = "required-remainder", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> requiredRemainderGetArray(@RequestParam(name = "data") String[] data) {
		try {
			return new ResponseEntity<>(remainderServices.processGet(data), HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, e), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
}

package com.saber.spring6webserverdemo.controllers;


import com.saber.spring6webserverdemo.dto.ErrorResponseDto;
import com.saber.spring6webserverdemo.dto.HelloResponseDto;
import com.saber.spring6webserverdemo.services.Headers;
import com.saber.spring6webserverdemo.services.HelloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "${service.api.base-path}/hello", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "hello", description = "hello service")
@RequiredArgsConstructor
@Validated
public class HelloController {

    private final HelloService helloService;

    @GetMapping(value = "/sayHello")
    @Operation(summary = "sayHello", description = "say Hello",
            parameters = {
                    @Parameter(name = Headers.firstName, in = ParameterIn.QUERY, required = true, example = "saber"),
                    @Parameter(name = Headers.lastName, in = ParameterIn.QUERY, required = true, example = "Azizi")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = HelloResponseDto.class))}),
                    @ApiResponse(responseCode = "400", description = "BAD_REQUEST",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class))}),
                    @ApiResponse(responseCode = "401", description = "UNAUTHORIZED",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class))}),
                    @ApiResponse(responseCode = "403", description = "FORBIDDEN",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class))}),
                    @ApiResponse(responseCode = "404", description = "NOT_FOUND",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class))}),
                    @ApiResponse(responseCode = "406", description = "NOT_ACCEPTABLE",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class))}),
                    @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class))}),
                    @ApiResponse(responseCode = "503", description = "SERVICE_UNAVAILABLE",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class))}),
                    @ApiResponse(responseCode = "504", description = "GATEWAY_TIMEOUT",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class))}),
            })
    public ResponseEntity<HelloResponseDto> sayHello(@RequestParam(value = "firstName") @NotBlank(message = "firstName is Required") String firstName, @RequestParam(value = "lastName")@NotBlank(message = "lastName is Required") String lastName) {
        HelloResponseDto hello = this.helloService.sayHello(firstName, lastName);
        return ResponseEntity.ok(hello);
    }
}

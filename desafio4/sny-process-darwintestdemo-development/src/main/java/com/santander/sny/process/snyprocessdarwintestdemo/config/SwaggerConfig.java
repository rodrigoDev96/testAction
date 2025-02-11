package com.santander.sny.process.snyprocessdarwintestdemo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.HeaderParameter;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Creates the necessary objects to configure Springdoc OpenAPI. OpenAPI automates the
 * generation of API documentation using spring boot projects This class only will be
 * loaded with Non production profile.
 *
 * @author Santander Technology
 */
@Configuration(proxyBeanMethods = false)
class SwaggerConfig {

	/**
	 * Creates Springdoc object where the API Documentation is grouped by package and path
	 * pattern
	 * @return GroupedOpenApi
	 */
	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder().group("api-web")
				.packagesToScan("com.santander.sny.process.snyprocessdarwintestdemo.web")
				.addOpenApiCustomizer(this.customerGlobalHeaderOpenApiCustomiser()).build();
	}

	/**
	 * Creates Springdoc object where it is defined or described the API definition.
	 * @return OpenAPI
	 */
	@Bean
	public OpenAPI apiInfo() {
		return new OpenAPI().info(new Info()
						.title("sny-process-darwintestdemo")
						.description("DARWINTESTDEMO")
						.version("1.0.0-SNAPSHOT"))
				.components(new Components().addSecuritySchemes("BearerAuth",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
				.addSecurityItem(new SecurityRequirement().addList("BearerAuth"));
	}

	/**
	 * Add all default architecture headers
	 * @return OpenApiCustomizer
	 */
	public OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {
		// Arq headers. Explain in
		// https://confluence.ci.gsnet.corp/pages/viewpage.action?pageId=213326163
		return (OpenAPI openApi) -> {
		openApi.components(addCommonParameters(openApi.getComponents()));
		openApi.components(addLoggingParameters(openApi.getComponents()));
		setHeaders(openApi);
		};
	}

	/**
	 * Add commons parameters in OpeApi.
	 * @param comp components
	 * @return components
	 */
	private static Components addCommonParameters(Components comp) {
		return comp.addParameters("x-santander-client-id",
				new HeaderParameter().required(Boolean.FALSE).name("x-santander-client-id")
						.description("""
										Identify the calling application.
										It originates from the client that calls an API, either a presentation
										component or a microservice.
										""")
						.schema(new StringSchema()).example("regapi"));

	}

	/**
	 * Add logging parameters in OpeApi.
	 * @param comp components
	 * @return components
	 */
	private static Components addLoggingParameters(Components comp) {
		return comp.addParameters("Contact-Point", new HeaderParameter()
								.required(Boolean.FALSE)
								.name("Contact-Point")
								.description("Id (appKey) of the application that initiates a request and it's " +
										"propagated among all applications. It originates from the presentation" +
										" component and must be propagated through all communications.")
								.schema(new StringSchema())
								.example("SPA")
						)
				.addParameters("User-Agent", new HeaderParameter()
						.required(Boolean.FALSE)
						.name("User-Agent")
						.description("Identify the technical characteristics of the device who make a network" +
								" request and with which the user interacts. It originates from the client " +
								"that calls an API, either a presentation component or a microservice.")
						.schema(new StringSchema())
						.example("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
								"(KHTML, like Gecko) Chrome/86.0.4240.111 Safari/537.36")
				)
				.addParameters("X-B3-TraceId", new HeaderParameter()
						.required(Boolean.FALSE)
						.name("X-B3-TraceId")
						.description("Unique correlate identifier of a request, indicates the overall ID of " +
								"the trace. It originates from the gateway and must be propagated through all " +
								"communications.")
						.schema(new StringSchema())
						.example("163ef67500d8b813")
				)
				.addParameters("X-B3-SpanId", new HeaderParameter()
						.required(Boolean.FALSE)
						.name("X-B3-SpanId")
						.description("""
								Identifier of the traces in a component in the same request.
								Generated in all backend components.
								""")
						.schema(new StringSchema())
						.example("f5cec96a6d76ce01")
				);

	}


	/**
	 * Set Header to propagation.
	 * @param openApi
	 */
	private static void setHeaders(OpenAPI openApi) {
		if (openApi.getPaths() != null) {
			openApi.getPaths().values().stream().flatMap(pathItem -> pathItem.readOperations().stream())
					.forEach(SwaggerConfig::addHttpHeaders);
		}
	}

	private static void addHttpHeaders(Operation operation) {
		operation.addParametersItem(new HeaderParameter().$ref("#/components/parameters/x-santander-client-id"));
	}

}

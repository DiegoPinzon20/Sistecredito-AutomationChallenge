# ¡Reto Automatizador! ?

Este es un proyecto de automatización de pruebas de aceptación usando **Java** como lenguaje de desarrollo, además se implementa el patrón **Screenplay** para la escritura de pruebas usando el core de **Serenity**. En este proyecto los requerimientos se escriben en lenguaje **Gherkin** con la implementación de **Cucumber** para Java.

Las pruebas están centradas en el sitio web de compras de [Falabella](https://www.falabella.com.co/falabella-co) con los siguientes escenarios:

- Buscar productos
- Agregar productos al carrito
- Ingresar información de envío

## Pre requisitos para ejecutar ?
- Java version 1.8 o superior y JDK (variables de entorno configuradas).
- Eclipse IDE o IntelliJ IDEA
- Gradle version 6.0 o higher (variables de entorno configuradas).
- Cucumber for Java Plugin
- Gherkin Plugin

## Ejecutar pruebas ?

La herramienta de compilación de código y administrador de dependencias para este proyecto es **Gradle**, así que pare ejecutar las pruebas use el siguiente comando en la raíz del proyecto.

	gradle clean test aggregate -i

Si desea ejecutar algún Runner especifico puede usar el siguiente comando, por ejemplo para el Login.

    gradle clean test --tests "LoginRunner"

## Navegador Web ?
Actualmente la automatización ejecuta por defecto con Chrome.

## Obtener el código

El código de la automatización está alojado en un repositorio de GitHub, para hacer uso de él puede clonarlo usando Git o descargar el archivo zip del proyecto.

Git:

	 git clone https://github.com/DiegoPinzon20/Sistecredito-AutomationChallenge.git
	 cd Sistecredito-AutomationChallenge

O simplemente [descargar archivo zip](https://github.com/DiegoPinzon20/Sistecredito-AutomationChallenge/archive/refs/heads/master.zip).

## Ver los informes
El comando proporcionado anteriormente para la ejecución de las pruebas, generará un informe de prueba de Serenity **index.html** en el directorio target/site/serenity. Adicionalmente, puede encontrar evidencias generadas por Cucumber en la ruta **target/serenity-reports**, son los siguientes archivos:

- **rerun.txt**: Archivo de texto con la información de la línea donde falló el caso para su revisión.
- **serenity-html-report.html**: Reporte generado con el resultado de cada uno de los pasos del feature incluido en las pruebas.
- **serenity-summary.html**: Este reporte es un resumen muy general sobre los resultados de la ejecución, si desea obtenerlo ejecute el comando:
  ```gradle reports```

## Construido con ?
La automatización fue desarrollada con:
- BDD - Estrategia de desarrollo basada en el comportamiento
- Screenplay - Patrón de diseño de escritura de pruebas
- Gradle - Administrador del proyecto, dependencias y plugins
- Selenium Web Driver - Herramienta para interactuar con navegadores web
- Cucumber - Implementación de lenguaje Gherkin para java
- Serenity BDD - Librería de código abierto para escribir pruebas de aceptación automatizadas
- Gherkin - Lenguaje DSL de lectura empresarial (lenguaje específico de dominio)

## Versionamiento ?
Se usó Git para el control de versiones. ?

## Autor ?

**Diego Pinzón** - [diegopip62@gmail.com]()
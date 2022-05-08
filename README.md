# �Reto Automatizador! ?

Este es un proyecto de automatizaci�n de pruebas de aceptaci�n usando **Java** como lenguaje de desarrollo, adem�s se implementa el patr�n **Screenplay** para la escritura de pruebas usando el core de **Serenity**. En este proyecto los requerimientos se escriben en lenguaje **Gherkin** con la implementaci�n de **Cucumber** para Java.

Las pruebas est�n centradas en el sitio web de compras de [Falabella](https://www.falabella.com.co/falabella-co) con los siguientes escenarios:

- Buscar productos
- Agregar productos al carrito
- Ingresar informaci�n de env�o

## Pre requisitos para ejecutar ?
- Java version 1.8 o superior y JDK (variables de entorno configuradas).
- Eclipse IDE o IntelliJ IDEA
- Gradle version 6.0 o higher (variables de entorno configuradas).
- Cucumber for Java Plugin
- Gherkin Plugin

## Ejecutar pruebas ?

La herramienta de compilaci�n de c�digo y administrador de dependencias para este proyecto es **Gradle**, as� que pare ejecutar las pruebas use el siguiente comando en la ra�z del proyecto.

	gradle clean test aggregate -i

Si desea ejecutar alg�n Runner especifico puede usar el siguiente comando, por ejemplo para el Login.

    gradle clean test --tests "LoginRunner"

## Navegador Web ?
Actualmente la automatizaci�n ejecuta por defecto con Chrome.

## Obtener el c�digo

El c�digo de la automatizaci�n est� alojado en un repositorio de GitHub, para hacer uso de �l puede clonarlo usando Git o descargar el archivo zip del proyecto.

Git:

	 git clone https://github.com/DiegoPinzon20/Sistecredito-AutomationChallenge.git
	 cd Sistecredito-AutomationChallenge

O simplemente [descargar archivo zip](https://github.com/DiegoPinzon20/Sistecredito-AutomationChallenge/archive/refs/heads/master.zip).

## Ver los informes
El comando proporcionado anteriormente para la ejecuci�n de las pruebas, generar� un informe de prueba de Serenity **index.html** en el directorio target/site/serenity. Adicionalmente, puede encontrar evidencias generadas por Cucumber en la ruta **target/serenity-reports**, son los siguientes archivos:

- **rerun.txt**: Archivo de texto con la informaci�n de la l�nea donde fall� el caso para su revisi�n.
- **serenity-html-report.html**: Reporte generado con el resultado de cada uno de los pasos del feature incluido en las pruebas.
- **serenity-summary.html**: Este reporte es un resumen muy general sobre los resultados de la ejecuci�n, si desea obtenerlo ejecute el comando:
  ```gradle reports```

## Construido con ?
La automatizaci�n fue desarrollada con:
- BDD - Estrategia de desarrollo basada en el comportamiento
- Screenplay - Patr�n de dise�o de escritura de pruebas
- Gradle - Administrador del proyecto, dependencias y plugins
- Selenium Web Driver - Herramienta para interactuar con navegadores web
- Cucumber - Implementaci�n de lenguaje Gherkin para java
- Serenity BDD - Librer�a de c�digo abierto para escribir pruebas de aceptaci�n automatizadas
- Gherkin - Lenguaje DSL de lectura empresarial (lenguaje espec�fico de dominio)

## Versionamiento ?
Se us� Git para el control de versiones. ?

## Autor ?

**Diego Pinz�n** - [diegopip62@gmail.com]()
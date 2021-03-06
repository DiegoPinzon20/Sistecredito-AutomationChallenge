# 隆Reto Automatizador! 馃殌

Este es un proyecto de automatizaci贸n de pruebas de aceptaci贸n usando **Java** como lenguaje de desarrollo, adem谩s se implementa el patr贸n **Screenplay** para la escritura de pruebas usando el core de **Serenity**. En este proyecto los requerimientos se escriben en lenguaje **Gherkin** con la implementaci贸n de **Cucumber** para Java.

Las pruebas est谩n centradas en el sitio web de compras de [Falabella](https://www.falabella.com.co/falabella-co) con los siguientes escenarios:

- Buscar productos
- Agregar productos al carrito
- Ingresar informaci贸n de env铆o

## Pre requisitos para ejecutar 馃搵
- Java version 1.8 o superior y JDK (variables de entorno configuradas).
- Eclipse IDE o IntelliJ IDEA
- Gradle version 6.0 o higher (variables de entorno configuradas).
- Cucumber for Java Plugin
- Gherkin Plugin

## Ejecutar pruebas 馃敤

La herramienta de compilaci贸n de c贸digo y administrador de dependencias para este proyecto es **Gradle**, as铆 que pare ejecutar las pruebas use el siguiente comando en la ra铆z del proyecto.

	gradle clean test aggregate -i

Si desea ejecutar alg煤n Runner especifico puede usar el siguiente comando, por ejemplo para el Login.

    gradle clean test --tests "LoginRunner"

## Navegador Web 馃寪
Actualmente la automatizaci贸n ejecuta por defecto con Chrome.

## Obtener el c贸digo

El c贸digo de la automatizaci贸n est谩 alojado en un repositorio de GitHub, para hacer uso de 茅l puede clonarlo usando Git o descargar el archivo zip del proyecto.

Git:

	 git clone https://github.com/DiegoPinzon20/Sistecredito-AutomationChallenge.git
	 cd Sistecredito-AutomationChallenge

O simplemente [descargar archivo zip](https://github.com/DiegoPinzon20/Sistecredito-AutomationChallenge/archive/refs/heads/master.zip).

## Ver los informes
El comando proporcionado anteriormente para la ejecuci贸n de las pruebas, generar谩 un informe de prueba de Serenity **index.html** en el directorio target/site/serenity. Adicionalmente, puede encontrar evidencias generadas por Cucumber en la ruta **target/serenity-reports**, son los siguientes archivos:

- **rerun.txt**: Archivo de texto con la informaci贸n de la l铆nea donde fall贸 el caso para su revisi贸n.
- **serenity-html-report.html**: Reporte generado con el resultado de cada uno de los pasos del feature incluido en las pruebas.
- **serenity-summary.html**: Este reporte es un resumen muy general sobre los resultados de la ejecuci贸n, si desea obtenerlo ejecute el comando:
  ```gradle reports```

## Construido con 馃洜
La automatizaci贸n fue desarrollada con:
- BDD - Estrategia de desarrollo basada en el comportamiento
- Screenplay - Patr贸n de dise帽o de escritura de pruebas
- Gradle - Administrador del proyecto, dependencias y plugins
- Selenium Web Driver - Herramienta para interactuar con navegadores web
- Cucumber - Implementaci贸n de lenguaje Gherkin para java
- Serenity BDD - Librer铆a de c贸digo abierto para escribir pruebas de aceptaci贸n automatizadas
- Gherkin - Lenguaje DSL de lectura empresarial (lenguaje espec铆fico de dominio)

## Versionamiento 馃搶
Se us贸 Git para el control de versiones. 馃攢

## Autor 馃懆

**Diego Pinz贸n** - [diegopip62@gmail.com]()

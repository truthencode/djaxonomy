package io.truthencode.djaxonomy.etl.compat

object Configuration {
lazy val config = ConfigLoaderBuilder.default()
               .addResourceSource("/reference.conf")
               .build()
               .loadConfigOrThrow<Config>()
}
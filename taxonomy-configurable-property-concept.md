taxonomy type property support

a way of denoting how a particular property could be written or read to.
example models could be CLI, Env, ConfigFile
Configfile could potentially be multi-valued
in below example the file option is a YAML path, but they also support JSON and other common options
would include property files or I would think a FQN class which  could be directly / indirectly invoked such as a config class
or typesafe config class.
Further, I would think a config server URL or service such as spring config or stork:service or nammed annotation?
wow.

example
https://mooltiverse.github.io/nyx/guide/user/configuration-reference/release-types/#publication-services
Publication servicesPermalink
Name	releaseTypes/publicationServices
Type	list
Default	Empty
Command Line Option	--release-types-publication-services=<NAMES>
Environment Variable	NYX_RELEASE_TYPES_PUBLICATION_SERVICES=<NAMES>
Configuration File Option	releaseTypes/publicationServices
Related state attributes	 
# calls taxi build from powershell
$dcmd = 'docker run -v ''"' + $pwd + '":/taxi'' -e ''CLI_CMD="build"'' -u ''"999:998"'' taxilang/taxi-cli:1.30.5'
Invoke-Expression $dcmd
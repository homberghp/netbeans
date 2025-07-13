#!/bin/bash
# @author homberghp

function jarName2Target() {
    local jar=$1; shift
#    IFS='-' read -r -a parts <<< $(basename ${jar} .jar)
    #   echo "${parts[0]}:${parts[0]}:${parts[1]}"
    echo $(basename $jar .jar)
}

function getJarSum() { 
    local jar=$1; shift
    local artifactId="puk"
    local groupId="piekels"
    local version="1.2.3"
    local sumtarget="nix"
    propfileline=$(unzip -l ${jar} | grep pom.properties )
    if [ ! -z "${propfileline}" ]; then 
        propfile=$(echo ${propfileline} | cut  -d' '  -f 4 -)
        unzip -o -q ${jar} ${propfile}
        eval $(cat ${propfile}| dos2unix -O| grep -v \#)
        >&2 echo "propfile ${propfile}:"
        >&2 cat -n ${propfile}
        >&2 echo "result ${groupId}:${artifactId}:${version}"
        sumtarget="${groupId}:${artifactId}:${version}"
    else
        sumtarget=$(basename ${jar})
#        echo alt ${sumtarget}
    fi
    sum=$(sha1sum ${jar} | cut -d' ' -f 1 - | tr a-z A-Z )
    echo "${sum};${sumtarget};$(basename ${jar})"
#    rm -fr META-INF
}
#echo $
while [ $# -gt 0 ]; do
    jar=$1; shift
    getJarSum ${jar}
done

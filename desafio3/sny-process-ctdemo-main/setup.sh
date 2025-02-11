#!/bin/bash

repository=$1
fortify_project=$2
sonar_project_key=$3
internal_config=$4
component_response=$5
component_configuration_response=$6

echo repository: $repository
echo fortify_project: $fortify_project
echo sonar_project_key: $sonar_project_key
echo internal_config: $internal_config
echo component_response: $component_response
echo component_configuration_response: $component_configuration_response


# Setting the properties SONAR_PROJECT_KEY FORTIFY_PROJECT for the project in "./.gluon/ci/properties.env"


# Add your component initialization code here
command=""
eval $command
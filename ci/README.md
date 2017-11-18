# item-service CI/CD pipeline

## Login into Concourse

```
export CONCOURSE_DEMO=https://ci.examples.cf
export CONCOURSE_TEAM=demo
export CONCOURSE_USER=user
export CONCOURSE_PASSWORD=password

fly -t demo login -n $CONCOURSE_DEMO -u $CONCOURSE_USER -p $CONCOURSE_PASSWORD -c ${CONCOURSE_URL}
```

## Customize Credentials

```
cp credentials-examples.yml credentials.yml
vi credentials.yml
```

## Create Pipeline

```
fly -t demo set-pipeline -p item-service -c ci/pipeline.yml -l ci/credentials.yml
```

## Run Pipeline

```
fly -t demo unpause-pipeline -p item-service
```

## Destroy Pipeline

```
fly -t demo destroy-pipeline -p item-service
```

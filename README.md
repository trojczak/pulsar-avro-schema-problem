# Creating Pulsar topics and schemas

```bash
cd /pulsar/bin

./pulsar-admin topics create-partitioned-topic --partitions 1 persistent://public/default/person-input
./pulsar-admin topics create-subscription persistent://public/default/person-input -s person-input-sub

./pulsar-admin schemas upload \
    --filename /pulsar/schemas/Person.avsc \
     persistent://public/default/person-input

./pulsar-admin topics create-partitioned-topic --partitions 1 persistent://public/default/person-output
./pulsar-admin topics create-subscription persistent://public/default/person-output -s person-output-sub

./pulsar-admin schemas upload \
    --filename /pulsar/schemas/Person.avsc \
     persistent://public/default/person-output
```
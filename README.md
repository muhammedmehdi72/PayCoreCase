Kafka üzerinde oluşturulması gereken Topicler:
----------------------------------------------
bin/kafka-topics.sh --create --bootstrap-server :9092 --replication-factor 1 --partitions 1 --topic InsertTopic

bin/kafka-topics.sh --create --bootstrap-server :9092 --replication-factor 1 --partitions 1 --topic UpdateTopic

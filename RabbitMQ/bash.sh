 docker run -d --restart always --hostname localhost  --name rabbitmq -p 15672:15672 -p 5672:5672 rabbitmq:3-management
 docker ps -a
 docker exec -ti rabbitmq sh -c "rabbitmq-plugins enable rabbitmq_tracing"
 docker exec -ti rabbitmq sh -c "rabbitmqctl trace_on"
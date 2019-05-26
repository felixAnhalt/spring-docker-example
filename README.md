# spring-docker-example
A small spring boot and docker example with some intended mistakes to show how to work with docker.

### Mistakes and how to solve

#### Nullpointer to destroy application context
In docker-compose there is no restart attribute so that after the BuyingRestService starts and PostConstruct invocates the setup method,
the spring context will be destroyed because of a missing this-reference for the application context.

Solve with adding 'this.' in line 22.

#### Tests run through, even though application context is not able to start
In DemoDockerApplicationTests the Annotations to use the application context are commented. Just uncomment them.

#### One button under prices works, the other one doesn't
In BuyingRestService line 37 there is a substring(-1) returned which results in a ArrayOutOfBoundsException.
Just remove the substring method.

### All web-content is copied from colorlib.com . If you especially search for the website featured in this project, take a look at https://colorlib.com/wp/template/creative-agency/ .
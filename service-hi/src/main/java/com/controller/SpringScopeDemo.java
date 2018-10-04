package com.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class SpringScopeDemo {
}
@Component
@Scope( "session")
class SessionObj {

}
@Component
@Scope( "request")
class RequestObj {

}
@Component
@Scope( "prototype")
class PrototypeObj {

}
@Component
@Scope( "singleton")
class SingletonObj {

}
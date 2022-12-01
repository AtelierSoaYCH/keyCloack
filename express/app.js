/**
 * Created by acunningham on 07/04/17.
 */

'use strict';

const Keycloak = require('keycloak-connect');
const express = require('express');
const session = require('express-session');

const app = express();


var memoryStore = new session.MemoryStore();
var keycloak = new Keycloak({ store: memoryStore });

//session
app.use(session({
  secret:'thisShouldBeLongAndSecret',
  resave: false,
  saveUninitialized: true,
  store: memoryStore
}));

app.use(keycloak.middleware());

//route protected with Keycloak
app.get('/test', keycloak.protect(), function(req, res){
  res.send('you are authenticated');
});

//unprotected route
app.get('/',function(req,res){
  res.send('Hello World');
});

app.use( keycloak.middleware( { logout: '/'} ));

app.listen(8000, function () {
  console.log('Listening at http://localhost:8000');
});
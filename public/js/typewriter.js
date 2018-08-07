'use strict'

let welcomeMsg = "Hello!";
let str = welcomeMsg.split("");
let el = document.getElementById('type-writer');
(function animate() {
    str.length > 0 ? el.innerHTML += str.shift() : clearTimeout(running); 
    var running = setTimeout(animate, 100);
})();
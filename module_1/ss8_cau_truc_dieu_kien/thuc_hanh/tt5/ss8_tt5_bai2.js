let login = prompt("Enter:");
let message = (login == 'Employee') ?
    'Hello' :
    (login == 'Director') ?
      'Greetings' :
      (login == '') ?
        'Please enter your position' :
        'Undefined position';
alert(message);
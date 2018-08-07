'use strict'

$('#input-password, #input-match').on('keyup', function () {
    if ($('#input-password').val() == $('#input-match').val() && $('#input-password').val() != null) {
      $('#message').html('Passwords match').css('color', 'green');
      $('#register-btn').removeClass('disabled');
    } else 
      $('#message').html('Passwords do not match').css('color', 'red');
  });
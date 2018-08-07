'use strict'

$('#input-password, #pass-match').on('keyup', function () {
    if ($('#input-password').val() == $('#pass-match').val()) {
      $('#message').html('Passwords match').css('color', 'green');
      $('#register-btn').removeClass('disabled');
    } else 
      $('#message').html('Passwords do not match').css('color', 'red');
  });
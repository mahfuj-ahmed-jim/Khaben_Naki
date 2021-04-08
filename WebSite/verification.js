window.onload = function() {
    render();
};

function render() {
    window.recaptchaVerifier = new firebase.auth.RecaptchaVerifier('recaptcha-container');
    recaptchaVerifier.render();
}

function phoneAuth(){
	var SignupPhone = document.getElementById('sign_up_phone').value;

	firebase.auth().signInWithPhoneNumber(SignupPhone, window.recaptchaVerifier)
    .then(function(confirmationResult){
      // SMS sent. Prompt user to type the code from the message, then sign the
      // user in with confirmationResult.confirm(code).
      window.confirmationResult = confirmationResult;
      VerificationCode = confirmationResult;
      console.log(VerificationCode);
      alert('message sent');

      // ...
    }).catch(function(error){
      // Error; SMS not sent
      alert('message not sent');
    });
}

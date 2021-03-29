window.onload=function(){
	renfer();
}

function render() {
	window.recaptchaVerifier = new firebase.auth.RecaptchaVerifier('recapthca-container');
	recaptchaVerifier.render();

 
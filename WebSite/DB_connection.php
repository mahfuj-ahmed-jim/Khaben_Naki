<?php

	require __DIR__.'/vendor/autoload.php';		
	use Kreait\Firebase\Factory;

	$factory = (new Factory)
		->withServiceAccount('khabennaki-81411-firebase-adminsdk-7dlna-4f9cb3639c.json') //jeson added

		->withDatabaseUri('https://khabennaki-81411-default-rtdb.firebaseio.com/'); // database url connected

		$database = $factory->createDatabase(); // access to the database
?>
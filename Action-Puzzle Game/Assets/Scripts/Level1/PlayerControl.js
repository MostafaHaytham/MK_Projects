#pragma strict

var up: KeyCode;
var down: KeyCode;
var left:KeyCode;
var right:KeyCode;
var speed: float;
var next:KeyCode;
var restart:KeyCode;
var back:KeyCode;

function Update () {
	if(Input.GetKey(next)&& level1.pass>=2)
	{
		Application.LoadLevel(2);
	}
	
	else if(Input.GetKey(restart))
	{
		Application.LoadLevel(1);
		level1.pass=0;
	}
	
	else if(Input.GetKey(back))
	{
		Application.LoadLevel(0);
		level1.pass=0;
	}
	else if(Input.GetKey(up))
	{
		rigidbody2D.velocity.y=speed;
		
	}
	else if(Input.GetKey(down))
	{
		rigidbody2D.velocity.y=speed*-1;
	}
	else if(Input.GetKey(left))
	{
		rigidbody2D.velocity.x=speed*-1;
	}
	else if(Input.GetKey(right))
	{
		rigidbody2D.velocity.x=speed;
	}
	else
	{
		rigidbody2D.velocity.y=0;
		rigidbody2D.velocity.x=0;
	}

}
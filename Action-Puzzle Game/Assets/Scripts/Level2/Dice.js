#pragma strict



var up: KeyCode;
var down: KeyCode;
var left:KeyCode;
var right:KeyCode;

var speed: float=10;


function Start () {
		

}

function Update () {
	if(Input.GetKey(up))
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
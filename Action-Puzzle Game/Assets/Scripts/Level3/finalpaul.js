#pragma strict
var up: KeyCode;
var down: KeyCode;
var next:KeyCode;
var restart:KeyCode;
var back:KeyCode;
var speed:int=20;
static var b:int=0;
static var  bcount:int =0;
function Start () {
	transform.animation.Stop();
}

function Update () {
	 if(Input.GetKey(up))
	{
		rigidbody2D.velocity.y=speed;
		finalvigron.count=1;
		
	}
	else if(Input.GetKey(down))
	{
		rigidbody2D.velocity.y=speed*-1;
		finalvigron.count=2;
	}
	else if(wall.finall==1)
	{
		transform.animation.Play("finalpaulanim");
		wall.finall=2;
		}
	else if(Input.GetKey(next) && wall.end==1 )
	{
		Application.LoadLevel(8);
	}
	
	else if(Input.GetKey(restart))
	{
		Application.LoadLevel(6);
		finalpaul.bcount=0;
	}
		
	else if(Input.GetKey(back))
	{
		Application.LoadLevel(5);
	}
	else
	{
		rigidbody2D.velocity.y=0;
	}
	

}
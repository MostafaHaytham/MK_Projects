#pragma strict

var next:KeyCode;
var restart:KeyCode;
var back:KeyCode;
function Start () {
	transform.animation.Play("paullanim");
}

function Update () {
if(Input.GetKey(next) )
	{
		Application.LoadLevel(6);
	}
	
	else if(Input.GetKey(restart))
	{
		Application.LoadLevel(5);
		}
		
	else if(Input.GetKey(back))
	{
		Application.LoadLevel(4);
	}

}
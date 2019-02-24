#pragma strict
var que: KeyCode;
var back:KeyCode;

function Start () {
	transform.animation.Stop();
}

function Update () {
if(Input.GetKey(que))
	{
		transform.animation.Play("question");
		
	}
	else if(Input.GetKey(back))
	{
		transform.animation.Stop();
	}
	

}
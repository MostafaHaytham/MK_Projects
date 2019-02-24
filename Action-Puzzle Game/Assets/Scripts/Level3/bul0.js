#pragma strict
var fire: KeyCode;
function Start () {
	transform.animation.Stop();

}

function Update () {
if(Input.GetKey(fire))
{
	if(finalvigron.count==3)
	{
		transform.animation.Play("bulletanim0");
	}

}
}
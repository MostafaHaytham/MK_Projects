#pragma strict
var fire: KeyCode;
function Start () {
	transform.animation.Stop();
	transform.audio.Stop();

}

function Update () {
if(Input.GetKey(fire))
{
	if(finalvigron.count==1)
	{
		transform.animation.Play("bulletanim");
		transform.audio.Play();
	}

}
}
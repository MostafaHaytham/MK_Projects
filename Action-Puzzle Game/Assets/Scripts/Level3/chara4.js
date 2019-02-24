#pragma strict

function Start () {
	transform.animation.Stop();
}

function Update () {
	if(bg.ch4==1)
	{
		transform.animation.Play("charr4");
		bg.ch4=2;
		}

}
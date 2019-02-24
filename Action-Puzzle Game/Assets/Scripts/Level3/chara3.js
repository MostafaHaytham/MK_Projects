#pragma strict

function Start () {
	transform.animation.Stop();
}

function Update () {
	if(bg.ch3==1)
	{
		transform.animation.Play("charr3");
		bg.ch3=2;
		}

}
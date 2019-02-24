#pragma strict

function Start () {
	transform.animation.Stop();
}

function Update () {
	if(bg.ch2==1)
	{
		transform.animation.Play("charr2");
		bg.ch2=2;
		}

}
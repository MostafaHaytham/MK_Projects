#pragma strict

function Start () {
	transform.animation.Stop();
}

function Update () {
	if(bg.ch1==1)
	{
		transform.animation.Play("charr1");
		bg.ch1=2;
	}

}
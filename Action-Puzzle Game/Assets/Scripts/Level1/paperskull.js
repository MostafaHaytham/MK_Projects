#pragma strict

function Start () {
transform.animation.Stop();
}

function Update () {
if(dialoguecount.count==1)
{
	transform.animation.Play("s&panim");
	dialoguecount.count=2;

}
}
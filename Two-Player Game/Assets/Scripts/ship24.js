#pragma strict
static var health: int=2;
static var number:int=24;
function Start () {
transform.GetComponent.<AudioSource>().Stop();
	transform.GetComponent.<Animation>().Stop();
}

function Update () {
	if(health==0)
	{	
		transform.GetComponent.<AudioSource>().Play();
		transform.GetComponent.<Animation>().Play("xship24");
		health=-1;
		}

}
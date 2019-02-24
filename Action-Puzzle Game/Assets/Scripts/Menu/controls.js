#pragma strict

function Start () {

}

function Update () {

}
function OnGUI() {
	if(GUI.Button(Rect(1100,610,100,70), 'Back To Menu'))
	 {
		Application.LoadLevel(0);
	}
	}
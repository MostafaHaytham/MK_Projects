#pragma strict

function Start () {

}

function Update () {

}
function OnGUI() {
	if(GUI.Button(Rect(550,520,100,50), 'Start')) {
		Application.LoadLevel(1);
	}
	else if(GUI.Button(Rect(700,520,100,50), 'Controls')) {
		Application.LoadLevel(7);
	}
}
#pragma strict

function Start () {

}

function Update () {

}
function OnGUI() {
	if(GUI.Button(Rect(280,260,100,50), 'Computer')) {
		mainscript.computer=1;
		Application.LoadLevel(0);
	}
	else if(GUI.Button(Rect(480,260,100,50), 'Player')) {
		mainscript.computer=0;
		Application.LoadLevel(0);
	}
}
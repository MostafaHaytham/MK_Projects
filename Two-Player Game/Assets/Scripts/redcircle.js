#pragma strict
var anim:Animator;
var c1:KeyCode;
var c2:KeyCode;
var c3:KeyCode;
var c4:KeyCode;
function Start () {
		anim = GetComponent("Animator");
		anim.SetBool ("mainpos2", true);
}

function Update () {
if (Input.GetKey (c1) && mainscript.playercount==2 && mainscript.player==2 && mainscript.destroyedships[0]==0 ) {
			anim.SetBool ("rship1", true);
			anim.SetBool ("rship2", false);
			anim.SetBool ("rship3", false);
			anim.SetBool ("rship4", false);
			anim.SetBool ("mainpos2", false);
				}
		else if (Input.GetKey (c2) && mainscript.playercount==2 && mainscript.player==2 && mainscript.destroyedships[1]==0) {
			anim.SetBool ("rship2", true);
			anim.SetBool ("rship1", false);
			anim.SetBool ("rship3", false);
			anim.SetBool ("rship4", false);
			anim.SetBool ("mainpos2", false);
		}
		else if (Input.GetKey (c3)&& mainscript.playercount==2 && mainscript.player==2 && mainscript.destroyedships[2]==0) {
			anim.SetBool ("rship3", true);
			anim.SetBool ("rship2", false);
			anim.SetBool ("rship1", false);
			anim.SetBool ("rship4", false);
			anim.SetBool ("mainpos2", false);
		}
		else if (Input.GetKey (c4)&& mainscript.playercount==2 && mainscript.player==2 && mainscript.destroyedships[3]==0) {
			anim.SetBool ("rship4", true);
			anim.SetBool ("rship2", false);
			anim.SetBool ("rship3", false);
			anim.SetBool ("rship1", false);
			anim.SetBool ("mainpos2", false);
		}
		if (Input.GetKey (c1) && mainscript.playercount==2 && mainscript.player==1 && mainscript.destroyedships2[0]==0 ) {
			anim.SetBool ("rship21", true);
			anim.SetBool ("rship22", false);
			anim.SetBool ("rship23", false);
			anim.SetBool ("rship24", false);
			anim.SetBool ("mainpos2", false);
				}
		else if (Input.GetKey (c2) && mainscript.playercount==2 && mainscript.player==1 && mainscript.destroyedships2[1]==0) {
			anim.SetBool ("rship22", true);
			anim.SetBool ("rship21", false);
			anim.SetBool ("rship23", false);
			anim.SetBool ("rship24", false);
			anim.SetBool ("mainpos2", false);
		}
		else if (Input.GetKey (c3)&& mainscript.playercount==2 && mainscript.player==1 && mainscript.destroyedships2[2]==0) {
			anim.SetBool ("rship23", true);
			anim.SetBool ("rship22", false);
			anim.SetBool ("rship21", false);
			anim.SetBool ("rship24", false);
			anim.SetBool ("mainpos2", false);
		}
		else if (Input.GetKey (c4)&& mainscript.playercount==2 && mainscript.player==1 && mainscript.destroyedships2[3]==0) {
			anim.SetBool ("rship24", true);
			anim.SetBool ("rship22", false);
			anim.SetBool ("rship23", false);
			anim.SetBool ("rship21", false);
			anim.SetBool ("mainpos2", false);
		}
		else if(mainscript.playercount==4 && mainscript.player==2)
		{
			anim.SetBool ("mainpos2", true);
			anim.SetBool ("rship4", false);
			anim.SetBool ("rship2", false);
			anim.SetBool ("rship3", false);
			anim.SetBool ("rship1", false);
			}
			else if(mainscript.playercount==4 && mainscript.player==1)
		{
			anim.SetBool ("mainpos2", true);
			anim.SetBool ("rship24", false);
			anim.SetBool ("rship22", false);
			anim.SetBool ("rship23", false);
			anim.SetBool ("rship21", false);
			}

}
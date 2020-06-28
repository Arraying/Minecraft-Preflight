# Minecraft-Preflight

Switching Minecraft versions is and has always been irritating.
Options never persisted between switches.
When switching from 1.8.9 to 1.14.4, my sprint keybind was retained, but autojump enabled.
When switching back, my sprint key and resource pack reset.
Minecraft-Preflight (MCPF) aims to address these problems.

# Usage
### Setting up MCPF
1. Download the latest MCPF snapshot from the [repository](http://repo.arraying.de/#browse/browse:maven-snapshots:de%2Farraying%2Fmcpf).
2. Open up your `.minecraft` folder.
3. Copy and paste the MCPF .jar into your .minecraft folder and rename it to `mcpf.jar`.
4. Create a new folder inside of `.minecraft` called `mcpf`.

### Setting up a profile
Do this for every unique profile you want to retain settings for.
Firstly, you will need to come up with a unique identifier for this profile.
Generally, it's best if this is just alphabetical, rather than alphanumerical/special characters.
I am using "eight" for 1.8 and "fourteen" for 1.14.
Whenever you see `YOUR_IDENT` in these instructions, replace it with the identifier you came up with.

1. Come up with a unique identifier for this profile. For 1.14.4 I am using "fourteen". 
2. Create a new file in the `mcpf` folder called `YOUR_IDENT.txt`.
3. Copy and paste any settings from your `options.txt` file you want to retain for this version.
4. Open the Minecraft launcher.
5. Edit the profile you are using for your specific version.
6. Click on "More Options" and look for "JVM Arguments".
7. Append the following to the arguments: `-javaagent:mcpf.jar -Dmcpf=YOUR_IDENT`.
8. Make sure there is a space between `YOUR_IDENT` and whatever JVM argument comes next.
9. You're done!
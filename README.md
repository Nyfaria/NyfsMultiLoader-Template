# Nyf's MultiLoader Template

This project provides a Gradle project template that can compile mods for multiple modloaders using a common sourceset. This project does not require any third party libraries or dependencies. If you have any questions or want to discuss the project join the [Discord](https://discord.gg/vgQKt3HKnH).

## NyfsModdingTools Plugin

This template uses the **NyfsModdingTools** Gradle plugin which provides:

- **Version Catalog** - Pre-configured dependencies for popular modding libraries
- **Auto Package Sync** - Automatically refactors package names when you change `group` or `mod_id` in `gradle.properties`
- **Constants Sync** - Updates the `MODID` constant in your `Constants` class when `mod_id` changes
- **Entrypoint Sync** - Updates `fabric.mod.json` entrypoints when your initializer classes change

### Supported Minecraft Versions

| Version | Loaders |
|---------|---------|
| 1.20.1  | Fabric, Forge |
| 1.21.1  | Fabric, NeoForge |
| 1.21.3+ | Fabric, NeoForge |

### Natively Supported Libraries

The following libraries are available through the version catalog with pre-configured versions for each Minecraft version:

| Library | Description | Lib String | Versions |
|---------|-------------|------------|----------|
| **GeckoLib** | Animation library for entities and items | `nyfs.geckolib.common`<br>`nyfs.geckolib.fabric`<br>`nyfs.geckolib.neoforge` | 1.20.1, 1.21.1, 1.21.3+ |
| **SmartBrainLib** | AI/Brain system utilities | `nyfs.sbl.common`<br>`nyfs.sbl.fabric`<br>`nyfs.sbl.neoforge` | 1.20.1, 1.21.1, 1.21.3+ |
| **CommonNetwork** | Cross-loader networking library | `nyfs.commonnetwork.common`<br>`nyfs.commonnetwork.fabric`<br>`nyfs.commonnetwork.neoforge` | 1.20.1, 1.21.1, 1.21.3+ |
| **Forge Config API Port** | Config API for Fabric/NeoForge | `nyfs.config.api.common`<br>`nyfs.config.api.fabric` | 1.20.1, 1.21.1, 1.21.3+ |
| **MixinExtras** | Extended Mixin functionality | `nyfs.mixin.extras.common`<br>`nyfs.mixin.extras.fabric`<br>`nyfs.mixin.extras.neoforge` | All versions |
| **Fabric API** | Fabric modding API | `nyfs.fabric.api` | All Fabric versions |
| **Cardinal Components** | Component/capability system for Fabric | `nyfs.cc.base`<br>`nyfs.cc.entity` | 1.20.1 |
| **Capability Syncer** | Capability sync utilities | `nyfs.cap.syncer` | 1.20.1 |

### Using Libraries

In your `build.gradle` files, reference libraries using the version catalog:

```groovy
dependencies {
    implementation nyfs.geckolib.common
    implementation nyfs.sbl.common
    implementation nyfs.commonnetwork.common
}
```

For loader-specific modules:

```groovy
dependencies {
    implementation nyfs.geckolib.fabric
    implementation nyfs.geckolib.neoforge
}
```

### Mod Dependencies

The plugin provides a `modDeps` extension for managing mod dependencies with automatic metadata file modification. Use this in your loader-specific `build.gradle` files:

#### Required Mods
Mods that must be installed for your mod to work:

```groovy
modDeps.requiredMod(nyfs.geckolib.fabric)
modDeps.requiredMod("geckolib", "4.8.3", nyfs.geckolib.fabric)
```

- Adds to `modImplementation` (Fabric) or `implementation` (NeoForge)
- Adds to `depends` in `fabric.mod.json`
- Adds `type="required"` in `neoforge.mods.toml`

#### Optional Mods
Mods that add extra features but aren't required:

```groovy
modDeps.optionalMod(nyfs.geckolib.fabric)
modDeps.optionalMod("geckolib", "4.8.3", nyfs.geckolib.fabric)
```

- Adds to `modCompileOnly` (Fabric) or `compileOnly` (NeoForge)
- Adds to `suggests` in `fabric.mod.json`
- Adds `type="optional"` in `neoforge.mods.toml`

#### Embedded Mods
Mods that are bundled inside your mod's jar:

```groovy
modDeps.embeddedMod(nyfs.geckolib.fabric)
modDeps.embeddedMod("geckolib", "4.8.3", nyfs.geckolib.fabric)
```

- Adds to `include` + `modImplementation` (Fabric) or `jarJar` + `implementation` (NeoForge)
- Adds to `depends` in `fabric.mod.json`
- Adds `type="required"` in `neoforge.mods.toml`

The plugin automatically modifies `fabric.mod.json` and `neoforge.mods.toml` in the output jar (not source files).

## Getting Started

### IntelliJ IDEA
This guide will show how to import the MultiLoader Template into IntelliJ IDEA. The setup process is roughly equivalent to setting up the modloaders independently and should be very familiar to anyone who has worked with their MDKs.

1. Clone or download this repository to your computer.
2. Configure the project by editing the `group`, `mod_name`, `mod_author`, and `mod_id` properties in the `gradle.properties` file. You will also need to change the `rootProject.name`  property in `settings.gradle`, this should match the folder name of your project, or else IDEA may complain.
3. Open the template's root folder as a new project in IDEA. This is the folder that contains this README file and the gradlew executable.
4. If your default JVM/JDK is not Java 21 you will encounter an error when opening the project. This error is fixed by going to `File > Settings > Build, Execution, Deployment > Build Tools > Gradle > Gradle JVM` and changing the value to a valid Java 21 JVM. You will also need to set the Project SDK to Java 21. This can be done by going to `File > Project Structure > Project SDK`. Once both have been set open the Gradle tab in IDEA and click the refresh button to reload the project.
5. Open the Gradle tab in IDEA if it has not already been opened. Navigate to `Your Project > Common > Tasks > vanilla gradle > decompile`. Run this task to decompile Minecraft.
6. Open your Run/Debug Configurations. Under the Application category there should now be options to run NeoForge and Fabric projects. Select one of the client options and try to run it.
7. Assuming you were able to run the game in step 7 your workspace should now be set up.

### Auto Package Sync

When you change the `group` or `mod_id` in `gradle.properties`, the plugin will automatically:

1. Rename all package declarations and imports
2. Move source files to the new package directory
3. Update mixin configuration files
4. Update `fabric.mod.json` and `neoforge.mods.toml`
5. Update the `MODID`/`MOD_ID` constant in your `Constants` class
6. Update entrypoints in `fabric.mod.json` based on detected initializer classes

Simply refresh your Gradle project after changing the properties.

## Development Guide
When using this template the majority of your mod is developed in the Common project. The Common project is compiled against the vanilla game and is used to hold code that is shared between the different loader-specific versions of your mod. The Common project has no knowledge or access to ModLoader specific code, apis, or concepts. Code that requires something from a specific loader must be done through the project that is specific to that loader, such as the NeoForge or Fabric project.

Loader specific projects such as the NeoForge and Fabric project are used to load the Common project into the game. These projects also define code that is specific to that loader. Loader specific projects can access all of the code in the Common project. It is important to remember that the Common project can not access code from loader specific projects.

## Removing Platforms and Loaders
While the MultiLoader Template includes support for many platforms and loaders you can easily remove support for the ones you don't need. This can be done by deleting the subproject folder and then removing it from the `settings.gradle` file. For example if you wanted to remove support for Forge you would follow the following steps. 

1. Delete the subproject folder. For example, delete `MultiLoader-Template/forge`.
2. Remove the project from `settings.gradle`. For example, remove `include("forge")`.


Fatcow icon set
---------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/fatcowicons](http://artifacts.griffon-framework.org/plugin/fatcowicons)


Provides a shortcut for adding icons based on [Fatcow's free icon set][1].

Usage
-----

The following nodes will become available on a View script upon installing this plugin

| *Node*     | *Property* | *Type* | *Default*   | *Bindable* |
| ---------- | ---------- | ------ | ----------- | ---------- |
| fatcowIcon | icon       | String |             | no         |
|            | size       | int    | `16`        | no         |

Valid values for `icon` can be obtained by running **fatcow-icon-selector** and inspecting the tooltip of the chosen icon.

Valid values for `size` property are: 16, 32.

Scripts
-------

 * **fatcow-icon-selector** - launches a window that displays all available icons (Hover an icon to see the icon name)

[1]: http://www.fatcow.com/free-icons


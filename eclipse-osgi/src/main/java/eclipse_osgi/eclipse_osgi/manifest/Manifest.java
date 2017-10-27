package eclipse_osgi.eclipse_osgi.manifest;

public class Manifest {
	
	
	//org.eclipse.osgi.framework.internal.core.Constants
	public static void main(String[] args) {
		//Bundle-Version
		//Bundle-SymbolicName
		//Bundle-ClassPath   ;, 分割
		//Bundle-Activator    实现BundleActivator
		//Fragment-Host
		//DynamicImport-Package
		//Bundle-ManifestVersion
		//Require-Bundle     other Bundle-SymbolicName
		//Import-Package 
		//Export-Package
	}
	//service   ComponentConstants
	//Service-Component  xml
	
	
	
	//Dependencies
	// 文件等 抽象成资源 org.osgi.resource.Resource  如MANIFEST.MF
	
	// MANIFEST.MF 每一个行称为描述 desc
	
	//有两种特殊的desc 称为   Capability(能力),Requirement(要求)
	
	//Capability(能力),Requirement(要求)  拥有一些属性和指令，如 Export-Package: org.eclipse.osgi.event;version="1.0" 指令如filter
	
	//根据  Capability(能力),Requirement(要求) 分类组合成 Namespace
	
	//osgi 默认的一个命名空间      see  Framework Namespaces 规范
	
	//例如    Export-Package，Import-Package 属于  osgi.wiring.package 命名空间 具体类PackageNamespace
	
	
	//把 Capability(能力),Requirement(要求) 链接到一起的是Wire
	
	
	// Capability -------------Wire-------------Requirement
	
	
	
	
	//class loader
	
	
	
	//  boot class path  java.*
	//  fwk 
	// After a bundle is resolved 才创建 bundle class loader
	// 路径顺序      entry path，Bundle-ClassPath
	// 动态导入 不会影响 bundle 的解析过程

}

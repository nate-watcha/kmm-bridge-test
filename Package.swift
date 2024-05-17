// swift-tools-version:5.3
import PackageDescription

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let remoteKotlinUrl = "https://maven.pkg.github.com/nate-watcha/kmm-bridge-test/io/github/nate/watcha/allshared-kmmbridge/0.1.2/allshared-kmmbridge-0.1.2.zip"
let remoteKotlinChecksum = "a5cf22e0fae48722a65b869b63918594aa369b438e376e951d164be14043a59f"
let packageName = "allshared"
// END KMMBRIDGE BLOCK

let package = Package(
    name: packageName,
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: packageName,
            targets: [packageName]
        ),
    ],
    targets: [
        .binaryTarget(
            name: packageName,
            url: remoteKotlinUrl,
            checksum: remoteKotlinChecksum
        )
        ,
    ]
)
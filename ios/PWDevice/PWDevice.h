//
//  PWDevice.h
//  PWDevice
//
//  Created by Nick on 2018/9/18.
//  Copyright © 2018年 hisense. All rights reserved.
//

#import <Foundation/Foundation.h>


#if __has_include(<React/RCTAssert.h>)
#import <React/RCTBridgeModule.h>
#else
#import "RCTBridgeModule.h"
#endif

@interface PWDevice : NSObject <RCTBridgeModule>

@end

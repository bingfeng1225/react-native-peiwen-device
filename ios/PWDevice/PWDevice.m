//
//  PWDevice.m
//  PWDevice
//
//  Created by Nick on 2018/9/18.
//  Copyright © 2018年 hisense. All rights reserved.
//

#if __has_include(<React/RCTConvert.h>)
#import <React/RCTConvert.h>
#elif __has_include("RCTConvert.h")
#import "RCTConvert.h"
#else
#import "React/RCTConvert.h"   // Required when used as a Pod in a Swift project
#endif

#import "PWDevice.h"
#import "PWKeyChainStore.h"
#import<CommonCrypto/CommonDigest.h>

#define  UUID_SERVICE_KEY @"com.qd.peiwen.uuid.service"

@implementation PWDevice
RCT_EXPORT_MODULE();

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_METHOD(uniqueDeviceID:(RCTPromiseResolveBlock)resolve rejecter:(RCTPromiseRejectBlock)reject)
{
    NSString * uuid = (NSString *)[PWKeyChainStore load:UUID_SERVICE_KEY];
    //首次执行该方法时，uuid为空
    if (!uuid || [uuid isEqualToString:@""])
    {
        uuid = [NSString stringWithFormat:@"%@%@%@",@"IOS",[[NSUUID UUID] UUIDString],@"HS2"];
        //将该uuid保存到keychain
        [PWKeyChainStore save:UUID_SERVICE_KEY data:uuid];
    }
    resolve(uuid);
}

@end

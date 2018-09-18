//
//  PWKeyChainStore.h
//  PWDevice
//
//  Created by Nick on 2018/9/18.
//  Copyright © 2018年 hisense. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface PWKeyChainStore : NSObject
+ (id)load:(NSString *)service;
+ (void)deleteKeyData:(NSString *)service;
+ (void)save:(NSString *)service data:(id)data;
@end

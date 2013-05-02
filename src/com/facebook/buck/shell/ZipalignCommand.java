/*
 * Copyright 2012-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.shell;

import com.facebook.buck.util.AndroidPlatformTarget;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

public class ZipalignCommand extends ShellCommand {

  private final String inputFile;
  private final String outputFile;

  public ZipalignCommand(String inputFile, String outputFile) {
    this.inputFile = Preconditions.checkNotNull(inputFile);
    this.outputFile = Preconditions.checkNotNull(outputFile);
  }

  @Override
  protected ImmutableList<String> getShellCommandInternal(ExecutionContext context) {
    ImmutableList.Builder<String> args = ImmutableList.builder();

    AndroidPlatformTarget androidPlatformTarget = context.getAndroidPlatformTarget();
    args.add(androidPlatformTarget.getZipalignExecutable().getAbsolutePath());
    args.add("-f").add("4");
    args.add(inputFile);
    args.add(outputFile);
    return args.build();
  }

  @Override
  public String getShortName(ExecutionContext context) {
    return getDescription(context);
  }

}
